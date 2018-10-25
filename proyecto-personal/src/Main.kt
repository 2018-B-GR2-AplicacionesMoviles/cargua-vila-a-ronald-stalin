fun ingresarDatos(){
    BaseDeDatos.agregarProductos(Producto("arroz", Tipo("Granos"),2.0,2.50))
    BaseDeDatos.agregarProductos(Producto("frejol",Tipo("Granos"),1.0,1.00))
    BaseDeDatos.agregarProductos(Producto("atun",Tipo("enlatados"),2.0,3.75))
    BaseDeDatos.agregarProductos(Producto("pollo", Tipo("carnes blancas"),2.5,4.00))

}


fun menu(){

    loop@ do {
        println("\n\n************BIENVENIDO AL SISTEMAS DE VENTA DE VIVERES************\n\n")
        println("1. Buscar producto a vender ")
        println("2. Enlistar todos los productos seleccionados")
        println("3. Salir ")

        print("\tEscoga una opcion: ")
        val entrada = readLine()!!
        when(entrada){
            "1" -> {

                // Llama a la busqueda
                print("\nProducto a buscar: ")
                val nombreProducto = readLine()!!
                val respuesta = Controladores.findProducto(nombreProducto)
                if (respuesta != null) {
                    println("Producto encontrado: " +
                            "\nNombre: ${respuesta.nombre} " +
                            "\nTipo: ${respuesta.tipo.nombreTipo} " +
                            "\nPrecio: ${respuesta.precio}")

                    subMenu(respuesta)

                } else {
                    println("Producto no encontrado")

                }

            }
            "2" -> {
                if (Controladores.compra.size > 0) {
                    println("\tNombre\tTipo\tUnidades/Libras\tPrecio")
                    println("${Controladores.comprar("", "", "")}")
                } else {
                    println("\nNo tiene registrado ningun producto\n\n")

                }

            }
            "3"->{
                if (Controladores.compra.size > 0){
                    println("Desea Salir sin confirmar su compra?")
                    loop@ do{
                        print("Finalizar Compra 1(Si)/2(No) \n( 2 Para seguir comprando): ")
                        val respuesta = readLine()!!
                        when(respuesta){
                            "1" -> {
                                if (Controladores.compra.size > 0) {
                                    println("Gracias por su compra!!!!")
                                    println("\tNombre\tTipo\tUnidades/Libras\tPrecio")
                                    println("${Controladores.comprar("", "", "")}")
                                }else{
                                    println("Gracias")
                                }
                                break@loop
                            }
                            "2"->{
                                break@loop
                            }
                            else ->{
                                println("Opcion Incorrecta")
                            }

                        }
                        break@loop

                    }while (true)
                }
                println("Fin")
                break@loop
            }
            else -> {
                println("Ha ingresado una opcion incorrecta")
            }
        }

    }while (true)

}


fun subMenu(producto: Producto){
    loop@ do{
        print("Agregar (Si)1/2(No): ")
        val respuesta = readLine()!!
        when(respuesta){
            "1" -> {
                Controladores.agregar(producto)
                loop@ do{
                    print("Finalizar Compra 1(Si)/2(No) \n( 2 Para seguir comprando): ")
                    val respuesta = readLine()!!
                    when(respuesta){
                        "1" -> {
                            print("\nIngresa tu nombre: ")
                            val nombre = readLine()!!
                            print("\nIngresa tu apellido: ")
                            val apellido = readLine()!!
                            print("\nIngresa tu cedula: ")
                            val cedula = readLine()!!
                            println("Compra realizada con exito: ")
                            println("\tNombre\tTipo\tUnidades/Libras\tPrecio")
                            println("${Controladores.comprar(nombre,apellido,cedula)}")
                            break@loop
                        }
                        "2"->{
                            break@loop
                        }
                        else ->{
                            println("Opcion Incorrecta")
                        }

                    }
                    break@loop

                }while (true)
            }
            "2" ->{
                break@loop
            }
            else ->{
                println("Opcion incorrecta")
            }
        }
        break@loop

    }while (true)
}

fun main(args: Array<String>){
    ingresarDatos()
    menu()
}