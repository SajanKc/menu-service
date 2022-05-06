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
package com.iamsajan.menuservice.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 6, 2022
 */

@Getter
@Setter
public class SubMenuUpdateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String title;
  private String link;
}
