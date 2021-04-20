<template>
  <div>
    <h1>Todo-List</h1>
    <p>A simple todo list. <a @click="() => this.loadTodoList()">[Refresh]</a></p>

    <div class="table-responsive">
      <table class="table table-striped">
        <thead>
          <tr>
            <th></th>
            <th><p class="table-list-title">Id</p></th>
            <th class="table-cell-expand">Title</th>
            <th class="table-cell-expand">Description</th>
            <th class="table-cell-expand">Created user</th>
            <th>DueDate</th>
            <th></th>
          </tr>
        </thead>
        <tr v-bind:key="todoItem.todoItmeId" v-for="todoItem in todolist" :class="todoItem.doneFlag?'done-text':''">
            <td>
                <input type="checkbox" :checked="todoItem.doneFlag" @change="updateDoneFlag(todoItem.todoItemId, todoItem.doneFlag)" />
            </td>
            <td>{{ todoItem.todoItemId }}</td>
            <td class="table-cell-expand">{{ todoItem.title }}</td>
            <td class="table-cell-expand">{{ todoItem.description }}</td>
            <td class="table-cell-expand">{{ todoItem.userName }}</td>
            <td>{{ todoItem.dueDate }}</td>
            <th></th>
        </tr>
        <tr>
            <td/>
            <td/>
            <td>
                <input type="textbox" v-model="title" />
            </td>
            <td>
                <input type="textbox" v-model="description"/>
            </td>
            <td>
                <input type="textbox" v-model="userName"/>
            </td>
            <td>
                <input type="textbox" v-model="dueDate"/>
            </td>
            <td>
                <button type="button" @click="() => this.addThisTodoItem()">+</button>
            </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import { getTodolist, todoItemDone, todoItemUndo, addTodoItem } from "../client/rest-client";

export default {
  methods: {
    loadTodoList: function () {
      getTodolist()
        .then((data) => {
          this.todolist = data.items;
        })
        .catch((err) => {
          this.$emit("error", err);
        });
    },
    updateDoneFlag(todoItemId, doneFlag) {
        if(doneFlag){
            todoItemUndo(todoItemId)
                .then(()=> this.loadTodoList())
                .catch((err) => {
                this.$emit("error", err);
                });
        }else{
            todoItemDone(todoItemId)
                .then(()=> this.loadTodoList())
                .catch((err) => {
                this.$emit("error", err);
                });
        }
    },
    addThisTodoItem: function () {
      addTodoItem(this.title, this.description, this.userName, this.dueDate)
        .then(()=> {
                this.loadTodoList();
                this.title = '';
                this.description = '';
                this.userName = '';
                this.dueDate = '';
            }
        )
        .catch((err) => {
          this.$emit("error", err);
        });
    },
  },
  data() {
    return {
      todolist: [],
      title: '',
      description: '',
      userName: '',
      dueDate: ''
    };
  },
  async mounted() {
    this.loadTodoList();
  },
  props: {
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.table-striped {
  margin-left: auto;
  margin-right: auto;
}
h3 {
  margin: 40px 0 0;
}
ul {
  padding: 0;
}
li {
  margin: 0 10px;
}
a {
  color: #00813a;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
.done-text{
 text-decoration: line-through;
}
</style>