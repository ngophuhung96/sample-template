/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.db.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vn.honagi.administrative.model.mongo.ApiTrafficDocument;

@Repository
public interface ApiTrafficCollectionRepository extends MongoRepository<ApiTrafficDocument, String> {
	
}
