package github.io.truongbn.elasticsearch.service.impl;

import java.util.List;

import org.apache.commons.collections4.IterableSortedMap;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import github.io.truongbn.elasticsearch.model.Item;
import github.io.truongbn.elasticsearch.repository.ItemRepository;
import github.io.truongbn.elasticsearch.service.ItemService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ElasticsearchOperations operations;

    @Override
    public Item findById(int id)  {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findByName(String itemName) {
        return itemRepository.findByName(itemName);
    }

    @Override
    public List<Item> findByCategory(String category) {
        return itemRepository.findByCategory(category);
    }

    @Override
    public List<Item> findByPriceBetween(double low, double high) {
        return itemRepository.findByPriceBetween(low, high);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

//    @Override
//    public Item saveItemToIndex(String indexName,Item item) {
////        return itemRepository.saveToIndex(item);
//
//        Query query = new SearchQuery("{ \"match\": { \"firstname\": { \"query\": \"Jack\" } } } ");
//        SearchHits<Person> searchHits = operations.search(query, Person.class);
//    }
}
