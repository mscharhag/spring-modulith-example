package de.ruv.demo.inventory

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
    allowedDependencies = ["shared"],

)
class ModuleMetaData