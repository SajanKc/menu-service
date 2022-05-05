/*************************************************************************
 * 
 * AADIM INNOVATION CONFIDENTIAL __________________
 *
 * All Rights Reserved.
 * 
 * NOTICE: All information contained here in is, and remains the property of Aadim Innovation and
 * its suppliers, if any. The intellectual and technical concepts contained here in are proprietary
 * to Aadim Innovation. Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Aadim Innovation.
 * 
 */
package com.iamsajan.menuservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.iamsajan.menuservice.dto.MenuCreateDto;
import com.iamsajan.menuservice.dto.MenuResponseDto;
import com.iamsajan.menuservice.dto.MenuResponseListDto;
import com.iamsajan.menuservice.dto.MenuUpdateDto;
import com.iamsajan.menuservice.dto.SubMenuCreateDto;
import com.iamsajan.menuservice.dto.SubMenuDto;
import com.iamsajan.menuservice.entity.Menu;
import com.iamsajan.menuservice.entity.SubMenu;
import com.iamsajan.menuservice.repository.MenuRepository;
import com.iamsajan.menuservice.repository.SubMenuRepository;

/**
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 5, 2022
 */
@Service
public class MenuService {

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private SubMenuRepository subMenuRepository;

  /**
   * @param menu
   * @return
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  private MenuResponseDto getMenuResponseDto(Menu menu) {
    MenuResponseDto response = new MenuResponseDto();

    response.setId(menu.getId());
    response.setTitle(menu.getTitle());
    response.setLink(menu.getLink());

    List<SubMenu> subMenus = subMenuRepository.findByMenuId(menu.getId());

    List<SubMenuDto> subMenuDtoList = new ArrayList<>();

    for (SubMenu subMenu : subMenus) {
      SubMenuDto subMenuDto = new SubMenuDto();
      subMenuDto.setId(subMenu.getId());
      subMenuDto.setTitle(subMenu.getTitle());
      subMenuDto.setLink(subMenu.getLink());
      subMenuDtoList.add(subMenuDto);
    }
    response.setSubMenus(subMenuDtoList);
    return response;
  }

  /**
   * @return MenuResponseListDto
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  public MenuResponseListDto getMenus() {
    List<MenuResponseDto> menuResponseList = new ArrayList<>();

    List<Menu> menus = menuRepository.findAll();

    for (Menu menu : menus) {
      menuResponseList.add(getMenuResponseDto(menu));
    }

    MenuResponseListDto response = new MenuResponseListDto();
    response.setMenus(menuResponseList);
    response.setTotal((long) menuResponseList.size());

    return response;
  }

  /**
   * @param menu
   * @return MenuResponseDto
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  public MenuResponseDto addNewMenu(MenuCreateDto menuCreateDto) {
    Menu menu = new Menu();
    menu.setTitle(menuCreateDto.getTitle());
    menu.setLink(menuCreateDto.getLink());

    Menu savedMenu = menuRepository.save(menu);
    return getMenuResponseDto(savedMenu);
  }

  /**
   * @param id
   * @param menuUpdateDto
   * @return MenuResponseDto
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  public MenuResponseDto updateMenu(Long id, MenuUpdateDto menuUpdateDto) {
    Optional<Menu> optionalMenu = menuRepository.findById(id);
    if (optionalMenu.isPresent()) {
      Menu menu = optionalMenu.get();
      menu.setTitle(menuUpdateDto.getTitle());
      menu.setLink(menuUpdateDto.getLink());

      Menu savedMenu = menuRepository.save(menu);
      return getMenuResponseDto(savedMenu);
    }
    return null;
  }

  /**
   * @param id
   * @author Sajan K.C.
   * @throws Exception
   * @since V1.0.0, Modified In: @version, By @author
   */
  public void deleteTeacherById(Long id) throws Exception {
    Optional<Menu> menu = menuRepository.findById(id);
    if (menu.isPresent())
      menuRepository.deleteById(id);
    else
      throw new Exception("menu with id " + id + " not found");
  }

  /**
   * @param menuIds
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  @Transactional
  public void deleteMenus(List<Long> menuIds) {
    menuRepository.deleteByIdIn(menuIds);
  }

  /**
   * @param id
   * @param subMenuCreateDto
   * @return MenuResponseDto
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  public MenuResponseDto addSubMenus(Long id, SubMenuCreateDto subMenuCreateDto) {
    Optional<Menu> optionalMenu = menuRepository.findById(id);
    if (optionalMenu.isPresent()) {
      Menu menu = optionalMenu.get();
      for (int i = 0; i < subMenuCreateDto.getSubMenus().size(); i++) {
        SubMenu subMenu = new SubMenu();
        SubMenuDto subMenuDto = subMenuCreateDto.getSubMenus().get(i);
        subMenu.setTitle(subMenuDto.getTitle());
        subMenu.setLink(subMenuDto.getLink());
        subMenu.setMenu(menu);

        subMenuRepository.save(subMenu);
      }
      return getMenuResponseDto(menu);
    }

    return null;
  }

  /**
   * @param menuId
   * @param subMenuIds
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  @Transactional
  public void deleteSubMenus(Long menuId, List<Long> subMenuIds) {
    subMenuRepository.deleteByIdInAndMenuId(subMenuIds, menuId);
  }

}
