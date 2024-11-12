<template>
    <div>
        <h4>TodoList</h4>
        <TodoListItem v-for="todoo in store.todos" :key="todoo.id" :todo="todoo"/>
    </div>
</template>

<script setup>
    import TodoListItem from './TodoListItem.vue';
    import { useTodosStore } from '@/stores/todos';

    const store = useTodosStore()
</script>

<style scoped>

</style>