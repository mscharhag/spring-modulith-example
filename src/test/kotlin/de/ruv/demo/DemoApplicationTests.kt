package de.ruv.demo

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaClass
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

@SpringBootTest
class DemoApplicationTests {

	@Test
	fun `list all modules`() {
		val modules = ApplicationModules.of(DemoApplication::class.java)
		modules.forEach(System.out::println)
	}

	@Test
	fun `list all modules except order`() {
		val modules = ApplicationModules.of(
			DemoApplication::class.java,
			JavaClass.Predicates.resideInAnyPackage("..order")
		)
		modules.forEach(System.out::println)
	}

	// The application’s main package is the one that the main application class resides in.
	// That is the class, that is annotated with @SpringBootApplication and usually contains the main(…) method.
    // By default, each direct sub-package of the main package is considered an application module package.

	@Test
	fun verify() {
		val modules = ApplicationModules.of(DemoApplication::class.java)
		modules.verify()

		// module circle
		// explicit dependencies
		// internal / public, rename, extract interface
		// adapter, service, etc. packages, hexagon
		//	@NamedInterface
		//  @NamedInterface with @PackageInfo an modulemeta
	}


	@Test
	fun document() {
		val modules = ApplicationModules.of(DemoApplication::class.java)
		Documenter(modules)
			.writeDocumentation()
			.writeAggregatingDocument()
	}
}
