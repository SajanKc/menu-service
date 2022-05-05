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
import org.springframework.stereotype.Repository;
import com.iamsajan.menuservice.entity.Menu;

/**
 * 
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 5, 2022
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

  /**
   * @param menuIds
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  void deleteByIdIn(List<Long> menuIds);

}
