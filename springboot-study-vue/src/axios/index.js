import axios from 'axios'

axios.defaults.timeout = 1000 * 60 * 10
axios.defaults.baseURL = '/api';

axios.interceptors.response.use(
    response => {
        console.log('interceptors.response',response)
        if(response && response.data )
            return Promise.resolve(response.data)
    },
    error => {
        return Promise.reject(error)
    }
)