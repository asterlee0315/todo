<template>
    <div>
        <h4>TodoForm</h4>
        <input type="text" v-model.trim="todoText" @keyup.enter="createTodo">
        <button @click="createTodo">등록</button>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useTodosStore } from '@/stores/todos';
    const store = useTodosStore()
    const todoText = ref("")

    const createTodo = function(){
        if(todoText.value){
            store.addTodo(todoText.value)
            todoText.value=''
        }else{
        alert('할일을 입력하시고 버튼을 누르시죠')}
    }
</script>

<style scoped>

</style>