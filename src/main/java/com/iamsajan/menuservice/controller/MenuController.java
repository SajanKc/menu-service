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
package com.iamsajan.menuservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iamsajan.menuservice.dto.MenuCreateDto;
import com.iamsajan.menuservice.dto.MenuResponseDto;
import com.iamsajan.menuservice.dto.MenuResponseListDto;
import com.iamsajan.menuservice.dto.MenuUpdateDto;
import com.iamsajan.menuservice.dto.SubMenuCreateDto;
import com.iamsajan.menuservice.service.MenuService;

/**
 * @author Sajan K.C.
 * @version
 * @since V1.0.0, May 5, 2022
 */

@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {

  @Autowired
  private MenuService menuService;

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public MenuResponseDto addMenus(@RequestBody MenuCreateDto menuCreateDto) {
    return menuService.addNewMenu(menuCreateDto);
  }

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public MenuResponseListDto getMenu() {
    return menuService.getMenus();
  }

  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public MenuResponseDto updateMenus(@PathVariable Long id,
      @RequestBody MenuUpdateDto menuUpdateDto) {
    return menuService.updateMenu(id, menuUpdateDto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteMenusById(@PathVariable Long id) throws Exception {
    menuService.deleteTeacherById(id);
  }

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteMenus(@RequestBody List<Long> menuIds) {
    menuService.deleteMenus(menuIds);
  }

  // SubMenu Controller

  @PostMapping("/{id}/sub-menus")
  @ResponseStatus(code = HttpStatus.CREATED)
  public MenuResponseDto addSubMenus(@PathVariable Long id,
      @RequestBody SubMenuCreateDto subMenuCreateDto) {
    return menuService.addSubMenus(id, subMenuCreateDto);
  }

  @DeleteMapping("/{menuId}/sub-menus")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteSubMenus(@PathVariable Long menuId, @RequestBody List<Long> subMenuIds) {
    menuService.deleteSubMenus(menuId, subMenuIds);
  }

}
