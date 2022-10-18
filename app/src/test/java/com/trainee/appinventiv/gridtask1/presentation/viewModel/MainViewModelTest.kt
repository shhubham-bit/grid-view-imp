package com.trainee.appinventiv.gridtask1.presentation.viewModel

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test



class MainViewModelTest{


    private lateinit var viewModel: MainViewModel

    @Before
    fun `initialSetUp`(){
        viewModel = MainViewModel()
        viewModel.initializeList()
    }

    @Test
    fun `return true, when we want to delete the item from nameList, that position is out of bound `(){
        val n= viewModel.nameList.size
        val newList = viewModel.deleteItemAtPosition(n)
        assertThat(newList == viewModel.nameList).isTrue()
    }


    @Test
    fun `return false, when item has been successfully deleted from nameList`(){
        val deletedItem = viewModel.nameList[2]
        val newList = viewModel.deleteItemAtPosition(2)
        assertThat(newList.contains(deletedItem)).isFalse()
    }

    @Test
    fun `return false, when insert item at position which is out of bound`(){
        val newItem = "new data add"
        val newList = viewModel.insertItemAtPosition(-2, newItem)
        assertThat(newList.contains(newItem)).isFalse()
    }

    @Test
    fun `return true, when we want to insert item at nameList_size +1 position`(){
        val n= viewModel.nameList.size+1
        val newItem = "add at tail"
        val newList = viewModel.insertItemAtPosition(n, newItem)
        assertThat(newList.contains(newItem)).isTrue()
        assertThat(newList[n]).isEqualTo("add at tail")
    }

    @Test
    fun `return true, insert item at particular position`(){
        val n= viewModel.nameList.size
        val newItem = "new data add"
        val newList = viewModel.insertItemAtPosition(n, newItem)
        assertThat(newList.contains(newItem)).isTrue()
        assertThat(newList[n]).isEqualTo("new data add")
    }


    @Test
    fun `return false, when we want to rename the item from position that is out of bound`(){
        val n= viewModel.nameList.size
        val modifiedValue = "shubham"
        val newList = viewModel.renameItemValue(n, modifiedValue)
        assertThat(newList.contains(modifiedValue)).isFalse()
    }


    @Test
    fun `return true, when successfully renamed item at that position `(){
        val modifiedValue = "shubham"
        val newList = viewModel.renameItemValue(2, modifiedValue)
        assertThat(newList.contains(modifiedValue)).isTrue()
    }


}