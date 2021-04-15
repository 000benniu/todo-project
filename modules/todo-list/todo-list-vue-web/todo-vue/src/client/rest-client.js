const SERVER_REST_ENDPOINT = 'http://localhost:8080/o/todo-list-restbuild/v1.0/todolist';
const AUTHORIZATION = 'Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0';

export const gettodolist = () =>
    request(`${SERVER_REST_ENDPOINT}/gettodolist`, 'GET', {});

export const todoItemDone = (todoItemId) =>
request(`${SERVER_REST_ENDPOINT}/markItemDone/${todoItemId}`, 'PATCH', {});

export const todoItemUndo = (todoItemId) =>
request(`${SERVER_REST_ENDPOINT}/markItemUndo/${todoItemId}`, 'PATCH', {});

function request(url, method, params, body) {

    var result = fetch(getURL(url, params), {
            body: JSON.stringify(body),
            headers: {
                Authorization: AUTHORIZATION,
                'Content-Type': 'application/json',
            },
            method: method || 'GET'
        }
    ).then(response => {
        if (response.status === 204) {
            alert(result);
            return result;
        }
        return response.json();
    }).catch(err => {
        console.log(err.response);
    });

    return result;
}

function getURL(path, params = {}) {
    const uri = new URL(path);

    const keys = Object.keys(params);

    keys.forEach(key => uri.searchParams.set(key, params[key]));

    return uri.toString();
}