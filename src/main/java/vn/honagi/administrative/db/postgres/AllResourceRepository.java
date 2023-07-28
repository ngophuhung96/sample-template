/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.db.postgres;

import java.util.Map;

import org.springframework.stereotype.Repository;

import org.postgresql.util.PGobject;

@Repository
public interface AllResourceRepository {
	
	Map<String, PGobject> listAllResource();
	
}
