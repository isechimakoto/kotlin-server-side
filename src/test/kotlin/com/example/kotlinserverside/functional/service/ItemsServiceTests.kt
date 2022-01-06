package com.example.kotlinserverside.functional.service

import com.example.kotlinserverside.entity.Item
import com.example.kotlinserverside.repository.ItemRepository
import com.example.kotlinserverside.service.ItemService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ItemsServiceTests(@Autowired private val itemService: ItemService) {
    @MockkBean private lateinit var mockItemRepository: ItemRepository

    val testItem1 = Item(id = 1, name = "test1", price = 100)
    val testItem2 = Item(id = 2, name = "test2", price = 200)
    val testItems = listOf(testItem1, testItem2)

    @Test
    fun testGetItemWithUpperCase() {
        every { mockItemRepository.findAll() } returns testItems

        val expectedItem1 = Item(id = 1, name = "TEST1", price = 100)
        val expectedItem2 = Item(id = 2, name = "TEST2", price = 200)
        val expectedItems = listOf(expectedItem1, expectedItem2)

        Assertions.assertEquals(expectedItems, itemService.getItemsWithUpperCase())

        verify { mockItemRepository.findAll() }
    }
}