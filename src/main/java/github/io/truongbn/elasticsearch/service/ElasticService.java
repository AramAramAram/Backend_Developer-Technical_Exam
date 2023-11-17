package github.io.truongbn.elasticsearch.service;

import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import github.io.truongbn.elasticsearch.model.Index;
import github.io.truongbn.elasticsearch.model.Item;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

//public interface ElasticService extends IndexOperations {
//public interface ElasticService extends IndexOperations {
//@Service
public interface ElasticService {

    CreateIndexResponse createIndex(String indexName) throws IOException;

    GetResponse getItemFromIndexById(String indexName, String id) throws IOException;
    IndexResponse saveItemToIndex(String indexName, Item item) throws IOException;


}
