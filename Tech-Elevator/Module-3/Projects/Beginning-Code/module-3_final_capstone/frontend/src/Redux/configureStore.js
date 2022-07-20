import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import {Token} from './token'
import {User} from './user'

export const ConfigureStore = () => {
    const store = createStore(
        combineReducers({
            token: Token,
            user: User
        }),
        applyMiddleware(thunk)
    );

    return store;
}