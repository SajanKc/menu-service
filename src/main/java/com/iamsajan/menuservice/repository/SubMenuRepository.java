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
package com.iamsajan.menuservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.iamsajan.menuservice.entity.SubMenu;

/**
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 5, 2022
 */
public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {

  /**
   * @param id
   * @return
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  List<SubMenu> findByMenuId(Long id);

  /**
   * @param menuId
   * @param subMenuIds
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  void deleteByIdInAndMenuId(List<Long> subMenuIds, Long menuId);

}
