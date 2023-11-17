package github.io.truongbn.elasticsearch.service.impl;

import java.io.IOException;
import java.util.List;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import github.io.truongbn.elasticsearch.model.Index;
import github.io.truongbn.elasticsearch.service.ElasticService;
import org.apache.commons.collections4.IterableSortedMap;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

import github.io.truongbn.elasticsearch.model.Item;
import github.io.truongbn.elasticsearch.repository.ItemRepository;
import github.io.truongbn.elasticsearch.service.ItemService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ElasticServiceImpl implements ElasticService {

////    private final ElasticService elasticService;
//    private final IndexOperations indexOperations;
//
//    @Override
//    public Boolean createIndex(String index)  {
//        return indexOperations.create();
//    }

    @Autowired
    ElasticsearchClient elasticsearchClient;
//    String indexName = "newIndex";

//    CreateIndexResponse createResponse = elasticsearchClient.indices().create(
//            new CreateIndexRequest.Builder()
//                    .index(indexName)
//                    .build()
//    );


    @Override
    public CreateIndexResponse createIndex(String indexName) throws IOException {
        return elasticsearchClient.indices().create(
                new CreateIndexRequest.Builder()
                        .index(indexName)
                        .build()
        );
    }


//    GetResponse<Product> response = esClient.get(g -> g
//                    .index("products")
//                    .id("bk-1"),
//            Product.class
//    );

    @Override
    public GetResponse getItemFromIndexById(String indexName, String id) throws IOException {
        return elasticsearchClient.get(g -> g
                    .index(indexName)
                    .id(id),
                    Item.class
        );
    }
    @Override
    public IndexResponse saveItemToIndex(String indexName, Item item) throws IOException {
        return elasticsearchClient.index(i -> i
            .index(indexName)
            .id(String.valueOf(item.getId()))
            .document(item)
        );
    }


//    esClient.indices().create(c -> c
//            .index("products")
//            );
//
//    Product product = new Product("bk-1", "City bike", 123.0);
//
//    IndexResponse response = esClient.index(i -> i
//            .index("products")
//            .id(product.getSku())
//            .document(product)
//    );
//
//logger.info("Indexed with version " + response.version());


}

