package github.io.truongbn.elasticsearch.controller;

import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import github.io.truongbn.elasticsearch.model.Item;
import github.io.truongbn.elasticsearch.service.ElasticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/elastic")
@RequiredArgsConstructor
public class ElasticController {


    private final ElasticService elasticService;




    @PostMapping("/index")
//    public CreateIndexResponse createIndex(@RequestBody String indexName) throws IOException {
    public CreateIndexResponse createIndex(@RequestParam String indexName) throws IOException {




//        return elasticsearchOperations.indexOps(Item.class).create();
//        return elasticsearchOperations.indexOps().

        return elasticService.createIndex(indexName);

    }

    @GetMapping("/index/{indexName}/item/{id}")
    public Item getItemFromIndexById(@PathVariable("indexName") String indexName, @PathVariable("id") String id) throws IOException {
        return (Item) elasticService.getItemFromIndexById(indexName, id).source();
    }
    @PostMapping("/index/{indexName}/item")
    public IndexResponse saveItemToIndex(@PathVariable("indexName") String indexName, @RequestBody Item item) throws IOException {
        return elasticService.saveItemToIndex(indexName, item);
    }




}
