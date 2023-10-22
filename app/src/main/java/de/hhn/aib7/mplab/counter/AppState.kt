


import org.reduxkotlin.Reducer
//import redux.*

data class AppState(val counter: Int = 0)

sealed class AppAction {
        data class Increment(val amount: Int) : AppAction()
        data class Decrement(val amount: Int) : AppAction()
}

val appReducer: Reducer<AppState> = { state, action ->
    when (action) {
        is AppAction.Increment -> state.copy(counter = state.counter + action.amount)
        is AppAction.Decrement -> state.copy(counter = state.counter - action.amount)
        else -> state
    }
}

// TEST
//val store = createStore(appReducer, AppState())



//store.dispatch(AppAction.Increment(1))
//store.dispatch(AppAction.Increment(1))