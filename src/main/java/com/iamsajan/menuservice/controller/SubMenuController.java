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
import com.iamsajan.menuservice.dto.MenuResponseDto;
import com.iamsajan.menuservice.dto.SubMenuCreateDto;
import com.iamsajan.menuservice.dto.SubMenuResponseDto;
import com.iamsajan.menuservice.dto.SubMenuUpdateDto;
import com.iamsajan.menuservice.service.MenuService;

/**
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 6, 2022
 */

@RestController
@RequestMapping("/api/v1")
public class SubMenuController {

  @Autowired
  private MenuService menuService;

  @PostMapping("/menus/{id}/sub-menus")
  @ResponseStatus(code = HttpStatus.CREATED)
  public MenuResponseDto addSubMenus(@PathVariable Long id,
      @RequestBody SubMenuCreateDto subMenuCreateDto) {
    return menuService.addSubMenus(id, subMenuCreateDto);
  }

  @GetMapping("/sub-menus/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public SubMenuResponseDto getSubMenusById(@PathVariable Long id) {
    return menuService.getSubMenuById(id);
  }

  @PutMapping("/sub-menus/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public SubMenuResponseDto updateSubMenus(@PathVariable Long id,
      @RequestBody SubMenuUpdateDto subMenuUpdateDto) {
    return menuService.updateSubMenu(id, subMenuUpdateDto);
  }

  @DeleteMapping("menus/{menuId}/sub-menus")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteSubMenus(@PathVariable Long menuId, @RequestBody List<Long> subMenuIds) {
    menuService.deleteSubMenus(menuId, subMenuIds);
  }

  @DeleteMapping("menus/{menuId}/delete-submenus")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteSubMenuByMenuId(@PathVariable Long menuId) {
    menuService.deleteSubMenus(menuId);
  }

}
