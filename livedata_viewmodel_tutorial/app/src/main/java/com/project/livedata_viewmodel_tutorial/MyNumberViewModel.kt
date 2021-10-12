package com.project.livedata_viewmodel_tutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType {
    PLUS, MINUS
}

// 데이터의 변경을 가짐
// 뷰모델은 데이터의 변경사항을 알려주는 라이브데이터를 가진다
class MyNumberViewModel : ViewModel() {

    // mutable 라이브 데이터 - 수정가능
    // 라이브 데이터 - 값 변동 안됨

    // 내부에 생성하는 데이터는 mutable로
    // 변경 가능하도록 설정
    private val _currentValue = MutableLiveData<Int>()

    // 변경되지 않는 데이터를 가져 올때 이름을 _ 언더스코어 없이 설정
    // 공개적으로 가져오는 변수는 private이 아닌 퍼블릭으로 외부에서도 접근 가능하도록 설정
    // 하지만 값을 직접 라이브 데이터에 접근하지 않고, 뷰모델을 통해 가져올 수 있도록 설정
    val currentValue: LiveData<Int>
        get() = _currentValue

    // 초기값 설정
    init {
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input: Int) {

        when (actionType) {
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }
}