package com.example.kotlinserverside.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

/**
 * Data class of the items table that assumed structure below.
 * create table items (
 *   id    INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
 *   name  varchar(32)            not null,
 *   price integer                not null
 * );
 */
@Table("items")
data class Item(
    @Id val id: Int,
    val name: String,
    val price: Int
)
