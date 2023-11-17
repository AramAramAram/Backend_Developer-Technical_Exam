package github.io.truongbn.elasticsearch.controller;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import github.io.truongbn.elasticsearch.model.Index;
import github.io.truongbn.elasticsearch.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.cluster.ClusterOperations;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.index.*;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.data.elasticsearch.core.reindex.ReindexRequest;
import org.springframework.data.elasticsearch.core.reindex.ReindexResponse;
import org.springframework.data.elasticsearch.core.routing.RoutingResolver;
import org.springframework.data.elasticsearch.core.script.Script;
import org.springframework.web.bind.annotation.*;

import github.io.truongbn.elasticsearch.model.Item;
import github.io.truongbn.elasticsearch.service.ItemService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/{name}")
    public List<Item> getItemByName(@PathVariable("name") String name) {
        return itemService.findByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Item> getItemsByCategory(@PathVariable("category") String category) {
        return itemService.findByCategory(category);
    }

    @GetMapping("/prices/{low}/{high}")
    public List<Item> getItemsByPriceRange(@PathVariable("low") double low,
            @PathVariable("high") double high) {
        return itemService.findByPriceBetween(low, high);
    }

    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable("id") int id) {
        return itemService.findById(id);
    }

    @PostMapping("/item")
    public Item saveItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }



}
