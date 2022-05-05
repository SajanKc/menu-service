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

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sajan K.C.
 * @version
 * @since V1.0.0, May 5, 2022
 */

@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public void getMenu() {
    System.out.println("Get mapping worked");
  }

}
