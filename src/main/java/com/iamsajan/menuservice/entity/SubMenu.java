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
package com.iamsajan.menuservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 5, 2022
 */
@Data
@Entity
@NoArgsConstructor
public class SubMenu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String link;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "subMenu_id")
  private Menu menu;

}
