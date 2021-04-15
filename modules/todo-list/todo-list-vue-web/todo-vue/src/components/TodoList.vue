<template>
  <div>
    <h1>Todo-List</h1>
    <p>A simple todo list.</p>

    <h1>
      <a @click="() => this.loadTodoList()">Refresh</a>
    </h1>

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
          </tr>
        </thead>
        <tr v-bind:key="todoItem.todoItmeId" v-for="todoItem in todolist" :class="todoItem.doneFlag?'done-text':''">
            <td>
                <input type="checkbox" :checked="todoItem.doneFlag" @change="updateDoneFlag(todoItem.todoItemId)" />
            </td>
            <td>{{ todoItem.todoItemId }}</td>
            <td class="table-cell-expand">{{ todoItem.title }}</td>
            <td class="table-cell-expand">{{ todoItem.description }}</td>
            <td class="table-cell-expand">{{ todoItem.userName }}</td>
            <td>{{ todoItem.dueDate }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import { gettodolist } from "../client/rest-client";

export default {
  methods: {
    loadTodoList: function () {
      gettodolist()
        .then((data) => {
          this.todolist = data.items;
        })
        .catch((err) => {
          this.$emit("error", err);
        });
    },
    // eslint-disable-next-line no-unused-vars
    filterByTitle: function (event) {
      this
        .loadAppointments
        //FILLME !
        ();
    },
    // eslint-disable-next-line no-unused-vars
    filterByDate: function (event) {
      this
        .loadAppointments
        //FILLME !
        ();
    },
    updateDoneFlag(id) {
        alert(id);
    },
  },
  data() {
    return {
      todolist: [],
    };
  },
  async mounted() {
    this.loadTodoList();
  },
  props: {},
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
  color: #04b654;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
.done-text{
 text-decoration: line-through;
}
</style>