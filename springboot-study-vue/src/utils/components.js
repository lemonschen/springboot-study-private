import CliDialog from '../components/dialog/CliDialog.vue'

const components = [
    CliDialog
]

const install = function (Vue) {
    components.map( component =>{
        Vue.component( component.name, component )
    })
}

export default {
    install
}