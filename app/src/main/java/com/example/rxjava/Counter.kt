package com.example.rxjava

import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject

object Counter {
	private val subject = PublishSubject.create<Int>()

	fun emit(count: Int) {
		subject.onNext(count)
	}

	fun listen(): Subject<Int> = subject

}