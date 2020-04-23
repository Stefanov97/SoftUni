package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.data.models.Item;
import com.stefanov.herobattles.data.repositories.ItemRepository;
import com.stefanov.herobattles.service.models.ItemServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ModelMapper mapper;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ModelMapper mapper, ItemRepository itemRepository){
        this.mapper = mapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public void createItem(ItemServiceModel item) {
        this.itemRepository.saveAndFlush(this.mapper.map(item, Item.class));
    }

    @Override
    public List<ItemServiceModel> getAll() {
        return this.itemRepository.findAll().stream().map(i-> this.mapper.map(i,ItemServiceModel.class)).collect(Collectors.toList());
    }
}
