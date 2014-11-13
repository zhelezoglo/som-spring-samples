package com.som.logic;

/**
 * @author som
 */
public class ItemService {

    CategoryService categoryService;

    public void moveItemToCategory_domainModel(Long itemId, Long categoryId) {
        Category newCategory = categoryService.getCategory(categoryId);
        Item item = this.getItem(itemId);
        item.moveToCategory(newCategory);
    }

    public void moveItemToCategory_transactionScript(Long itemId, Long categoryId) {
//        Category newCategory = categoryService.getCategory(categoryId);
//        Item item = this.getItem(itemId);
//        item.moveToCategory(newCategory);
    }


    public Item getItem(Long id) {
        return null;
    }

}
