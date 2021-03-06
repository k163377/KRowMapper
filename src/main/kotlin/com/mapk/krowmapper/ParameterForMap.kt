package com.mapk.krowmapper

import com.mapk.core.getAliasOrName
import kotlin.reflect.KClass
import kotlin.reflect.KParameter

class ParameterForMap<D : Any> private constructor(
    val name: String,
    val param: KParameter,
    val clazz: Class<D>
) {
    companion object {
        fun newInstance(param: KParameter, propertyNameConverter: (String) -> String = { it }): ParameterForMap<*> {
            return ParameterForMap(
                propertyNameConverter(param.getAliasOrName()!!),
                param,
                (param.type.classifier as KClass<*>).java
            )
        }
    }
}
