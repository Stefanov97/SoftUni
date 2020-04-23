package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.service.models.ItemServiceModel;

import java.util.List;

public interface ItemService {
    void createItem(ItemServiceModel item);
    List<ItemServiceModel> getAll();
}
