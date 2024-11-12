import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useTodosStore = defineStore('todos', () => {
  let id=0
  //state
  const todos = ref([
    {id: id++, text:'라이브 복습', isDone:false},
    {id: id++, text:'과제', isDone:false},
    {id: id++, text:'a형대비', isDone:false},
  ])
  //action
  const addTodo = function(todoText){
    todos.value.push({
      id: id++,
      text: todoText,
      isDone:false
    })
  }

  const deleteTodo = function(id){
    const idx = todos.value.findIndex((todo) => {
      return todo.id === id
    })
    todos.value.splice(idx,1)
  }

  const updateTodo = function(id){
    todos.value = todos.value.map((todo) => {
      if(todo.id == id){ todo.isDone=!todo.isDone}
      return todo
    })
  }

  //getters
  const doneTodoCount = computed(()=>{
    return todos.value.filter((todo)=>todo.isDone).length
  })
  return {todos, addTodo, deleteTodo, updateTodo, doneTodoCount}
})
