package com.example.kotlinserverside.service

import com.example.kotlinserverside.entity.Item
import com.example.kotlinserverside.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(private val itemRepository: ItemRepository) {
    fun getItemsWithUpperCase(): List<Item> = itemRepository.findAll().map {
        it.copy(name = it.name.uppercase())
    }
}