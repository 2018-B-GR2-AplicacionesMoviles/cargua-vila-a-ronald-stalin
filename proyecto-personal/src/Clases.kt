import java.util.*


class Tipo(public val nombreTipo: String){}

class Producto(val nombre: String,val tipo: Tipo, val unidades: Double,val precio:Double){
    override fun toString(): String{
        return "\t${this.nombre}\t${this.tipo.nombreTipo}\t\t${this.unidades}\t\t\t${this.precio}"
    }
}
class Usuario(val nombre: String, val apellido: String, val cedula: String){
    override fun toString(): String{
        return "nombre:  ${this.nombre} apellido: ${this.apellido} cedula: ${this.cedula}"
    }
}
class Detalle(val producto: Producto,val factura:Factura){
    override fun toString(): String {
        return "${this.producto}  \n"
    }
}
class Factura(val fechaFactura: Date,val codFactura:String,val usuario: Usuario)
class BaseDeDatos{
    companion object {
        val Producto: ArrayList<Producto> = ArrayList()
        val Detalles: ArrayList<Detalle> = ArrayList()
        val Facturas: ArrayList<Factura> = ArrayList()

        fun agregarProductos(producto: Producto){
            Producto.add(producto)
        }
        fun agregarFacturas(factura: Factura){
            Facturas.add(factura)
        }
        fun agregarDetalles(detalle: Detalle){
            Detalles.add(detalle)
        }
    }
}
class Controladores {

    companion object {
        var compra = ArrayList<Producto>()

        fun findProducto(nombre: String): Producto? {
            var Producto = BaseDeDatos.Producto
            for (producto in Producto) {
                if (producto.nombre == nombre) {
                    return producto
                }
            }
            return null
        }

        fun InfoUsuarios(nombre: String, apellido: String, cedula: String): Usuario {
            var usuario = Usuario(nombre, apellido, cedula)
            return usuario
        }

        fun agregar(producto: Producto) {
            compra.add(producto)
        }

        fun comprar(nombre: String, apellido: String, cedula: String): String {
            val fecha = Date()
            var ListaDetalles = ArrayList<Detalle>()
            var factura = Factura(fecha, fecha.toString() + 1, InfoUsuarios(nombre, apellido, cedula))
            var total: Double = 0.00
            for (producto in compra) {
                var detalle = Detalle(producto, factura)
                ListaDetalles.add(detalle)
                total += producto.precio
                BaseDeDatos.agregarDetalles(detalle)
            }
            BaseDeDatos.agregarFacturas(factura)
            var reporte = ""
            for (detalle in ListaDetalles) {
                reporte += "\n"+detalle
            }

            reporte +="\n Total: ${total}"
            return reporte
        }

        fun totalCarrito():Double{
            var total: Double = 0.00
            for (pelicula in compra){
                total += pelicula.precio
            }
            return  total
        }
    }
}
