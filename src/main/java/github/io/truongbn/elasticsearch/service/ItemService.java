package github.io.truongbn.elasticsearch.service;

import java.util.List;

import github.io.truongbn.elasticsearch.model.Item;

public interface ItemService {
    Item findById(int id);

    List<Item> findByName(String itemName);

    List<Item> findByCategory(String category);

    List<Item> findByPriceBetween(double low, double high);

    Item saveItem(Item item);
//    Item saveItemToIndex(String indexName, Item item);

}
