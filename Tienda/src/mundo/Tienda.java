/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Tienda que maneja 4 productos.
 */
public class Tienda {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: Lápiz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad mínima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad mínima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad mínima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad mínima: 20, Imagen: pan.png. <br>
     */
    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     *
     * @return Producto 1 de la tienda.
     */
    public Producto darPrimerProducto() {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     *
     * @return Producto 2 de la tienda.
     */
    public Producto darSegundoProducto() {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     *
     * @return Producto 3 de la tienda.
     */
    public Producto darTercerProducto() {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     *
     * @return Producto 4 de la tienda.
     */
    public Producto darCuartoProducto() {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     *
     * @return Dinero en caja.
     */
    public double darDineroEnCaja() {
        dineroEnCaja = 0;
        double iva1 = 0;
        double iva2 = 0;
        double iva3 = 0;
        double iva4 = 0;

        double valorProducto1 = 0;
        double valorProducto2 = 0;
        double valorProducto3 = 0;
        double valorProducto4 = 0;

        if(darPrimerProducto().darCantidadUnidadesVendidas()>0){
            valorProducto1 = darPrimerProducto().darValorUnitario()*
                    darPrimerProducto().darCantidadUnidadesVendidas();
            iva1 = darPrimerProducto().darIVA() * valorProducto1;
            valorProducto1 = valorProducto1 + iva1;
        }
        if(darSegundoProducto().darCantidadUnidadesVendidas()>0){
            valorProducto2 = darSegundoProducto().darValorUnitario()*
                    darSegundoProducto().darCantidadUnidadesVendidas();
            iva2 = darSegundoProducto().darIVA() * valorProducto2;
            valorProducto2 = valorProducto2 + iva2;
        }
        if(darTercerProducto().darCantidadUnidadesVendidas()>0){
            valorProducto3 = darTercerProducto().darValorUnitario()*
                    darTercerProducto().darCantidadUnidadesVendidas();
            iva3 = darTercerProducto().darIVA() * valorProducto3;
            valorProducto3 = valorProducto3 + iva3;
        }
        if(darCuartoProducto().darCantidadUnidadesVendidas()>0){
            valorProducto4 = darCuartoProducto().darValorUnitario()*
                    darCuartoProducto().darCantidadUnidadesVendidas();
            iva4 = darCuartoProducto().darIVA() * valorProducto4;
            valorProducto4 = valorProducto4 + iva4;
        }
        dineroEnCaja = valorProducto1 + valorProducto2 + valorProducto3 + valorProducto4;

        return dineroEnCaja;
    }

    /**
     * Retorna el producto con 
     * el nombre dado por parámetro.
     *
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Producto con el nombre dado por parámetro, null si no lo encuentra.
     */
    public Producto darProducto(String pNombre) {
        Producto buscado = null;
        //si el primer product tiene el nombre  buscado
        if (producto1.darNombre().equals(pNombre)){
            buscado = producto1;
        } else if (producto2.darNombre().equals(pNombre)) {
            buscado = producto2;

        }
        else if (producto3.darNombre().equals(pNombre)) {
            buscado = producto3;
        }
        else if (producto4.darNombre().equals(pNombre)) {
        buscado = producto4;}
        return buscado;

    }

    /**
     * Retorna el promedio de las ventas.
     *
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas() {
        double respuesta = 0.0;
        double iva1 = 0;
        double iva2 = 0;
        double iva3 = 0;
        double iva4 = 0;

        double valorProducto1 = 0;
        double valorProducto2 = 0;
        double valorProducto3 = 0;
        double valorProducto4 = 0;

        if(darPrimerProducto().darCantidadUnidadesVendidas()>0){
            valorProducto1 = darPrimerProducto().darValorUnitario()*
                    darPrimerProducto().darCantidadUnidadesVendidas();
            iva1 = darPrimerProducto().darIVA() * valorProducto1;
            valorProducto1 = valorProducto1 + iva1;
        }
        if(darSegundoProducto().darCantidadUnidadesVendidas()>0){
            valorProducto2 = darSegundoProducto().darValorUnitario()*
                    darSegundoProducto().darCantidadUnidadesVendidas();
            iva2 = darSegundoProducto().darIVA() * valorProducto2;
            valorProducto2 = valorProducto2 + iva2;
        }
        if(darTercerProducto().darCantidadUnidadesVendidas()>0){
            valorProducto3 = darTercerProducto().darValorUnitario()*
                    darTercerProducto().darCantidadUnidadesVendidas();
            iva3 = darTercerProducto().darIVA() * valorProducto3;
            valorProducto3 = valorProducto3 + iva3;
        }
        if(darCuartoProducto().darCantidadUnidadesVendidas()>0){
            valorProducto4 = darCuartoProducto().darValorUnitario()*
                    darCuartoProducto().darCantidadUnidadesVendidas();
            iva4 = darCuartoProducto().darIVA() * valorProducto4;
            valorProducto4 = valorProducto4 + iva4;
        }
        respuesta = valorProducto1 + valorProducto2 + valorProducto3 + valorProducto4;

        return respuesta/4;
    }

    /**
     * Retorna el producto con más unidades vendidas.
     *
     * @return Producto con más unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido() {

        Producto masVendido = null;

        if(darPrimerProducto().darCantidadUnidadesVendidas() > 0
                || darSegundoProducto().darCantidadUnidadesVendidas() > 0
                || darTercerProducto().darCantidadUnidadesVendidas() > 0
                || darCuartoProducto().darCantidadUnidadesVendidas() > 0){
            masVendido = darPrimerProducto();
            if (masVendido.darCantidadUnidadesVendidas() < darSegundoProducto().darCantidadUnidadesVendidas()){
                masVendido = darSegundoProducto();}
            if (masVendido.darCantidadUnidadesVendidas() < darTercerProducto().darCantidadUnidadesVendidas()){
                masVendido = darTercerProducto();
            }
            if (masVendido.darCantidadUnidadesVendidas() < darCuartoProducto().darCantidadUnidadesVendidas()){
                masVendido = darCuartoProducto();
            }
        }
        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     *
     * @return Producto con menos unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido() {
        Producto menosVendido = null;

        if(darPrimerProducto().darCantidadUnidadesVendidas() > 0
                || darSegundoProducto().darCantidadUnidadesVendidas() > 0
                || darTercerProducto().darCantidadUnidadesVendidas() > 0
                || darCuartoProducto().darCantidadUnidadesVendidas() > 0){
            menosVendido = darPrimerProducto();
            if (menosVendido.darCantidadUnidadesVendidas() > darSegundoProducto().darCantidadUnidadesVendidas()){
                menosVendido = darSegundoProducto();}
            if (menosVendido.darCantidadUnidadesVendidas() > darTercerProducto().darCantidadUnidadesVendidas()){
                menosVendido = darTercerProducto();
            }
            if (menosVendido.darCantidadUnidadesVendidas() > darCuartoProducto().darCantidadUnidadesVendidas()){
                menosVendido = darCuartoProducto();
            }
        }
        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por parámetro. <br>
     * <b>post: </b> Disminuyó la cantidad de unidades del producto dado
     * y se actualizó el dinero de la caja a partir de la cantidad real vendida multiplicada
     * por el precio final (con IVA) del producto vendido..
     *
     * @param pNombreProducto Nombre del producto a vender.
     * @param pCantidad       Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto(String pNombreProducto, int pCantidad) {
        int cantidadVendida = 0;
        Producto producto = darProducto(pNombreProducto);
        cantidadVendida = producto.vender(pCantidad);
        producto.cambiardarCantidadUnidadesVendidas(
                producto.darCantidadUnidadesVendidas() + cantidadVendida);
        return cantidadVendida;
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aumentó la cantidad de unidades en bodega del producto dado.
     *
     * @param pNombreProducto Nombre del producto a abastecer.
     * @param pCantidad       La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        boolean abastece = false;
        Producto producto = darProducto(pNombreProducto);

        if(pCantidad > 0){
            abastece = producto.abastecer(pCantidad);
        } else{
            return false;
        }
        return abastece;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por parámetro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad mínima fueron cambiados con los valores dados por parámetro.
     *
     * @param pNombreActual   Nombre actual del producto.
     * @param pNombreNuevo    Nuevo nombre del producto.
     * @param pTipo           Tipo del producto.
     * @param pValorUnitario  Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto.
     * @param pCantidadMinima Cantidad mínima en bodega para hacer un pedido del producto.
     * @param pRutaImagen     Ruta de la imagen del producto.
     * @return Retorna true si cambió la información del producto,
     * Retorna false si ya existía un producto con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        boolean cambio = false;
        Producto producto = darProducto(pNombreActual);

        if(!pNombreNuevo.equals(this.darPrimerProducto().darNombre()) &&
                !pNombreNuevo.equals(this.darSegundoProducto().darNombre()) &&
                !pNombreNuevo.equals(this.darTercerProducto().darNombre()) &&
                !pNombreNuevo.equals(this.darCuartoProducto().darNombre()) &&
                !pNombreNuevo.equals(pNombreActual)) {
            producto.cambiarNombre(pNombreNuevo);
            producto.cambiarCantidadBodega(pCantidadBodega);
            producto.cambiarTipo(pTipo);
            producto.cambiarCantidadMinima(pCantidadMinima);
            producto.cambiarValorUnitario(pValorUnitario);
            producto.cambiarRutaImagen(pRutaImagen);
            cambio = true;
        }
        return cambio;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de productos que tienen un precio inferior al promedio de los precios
     */
    public int metodo1() {
        double promedio = darPromedioVentas();
        Integer cantProductos = 0;

        double valorProducto1 = darPrimerProducto().darValorUnitario()
                * darPrimerProducto().darIVA();
        valorProducto1 = valorProducto1 + darPrimerProducto().darValorUnitario();
        double valorProducto2 = darSegundoProducto().darValorUnitario()
                * darSegundoProducto().darIVA();
        valorProducto2 = valorProducto2 + darSegundoProducto().darValorUnitario();
        double valorProducto3 = darTercerProducto().darValorUnitario()
                * darTercerProducto().darIVA();
        valorProducto3 = valorProducto3 + darTercerProducto().darValorUnitario();
        double valorProducto4 = darCuartoProducto().darValorUnitario()
                * darCuartoProducto().darIVA();
        valorProducto4 = valorProducto4 + darCuartoProducto().darValorUnitario();

        if(valorProducto1<promedio){
            cantProductos = cantProductos+1;
        }
        if(valorProducto2<promedio){
            cantProductos = cantProductos+1;
        }
        if(valorProducto3<promedio){
            cantProductos = cantProductos+1;
        }
        if(valorProducto4<promedio){
            cantProductos = cantProductos+1;
        }
        return cantProductos;
    }

    /**
     * Obtiene el nombre del producto más barato de la tienda
     */
    public String metodo2() {
        String nombreProducto = "";

        double valorProducto1 = darPrimerProducto().darValorUnitario()
                * darPrimerProducto().darIVA();
        valorProducto1 = valorProducto1 + darPrimerProducto().darValorUnitario();
        double valorProducto2 = darSegundoProducto().darValorUnitario()
                * darSegundoProducto().darIVA();
        valorProducto2 = valorProducto2 + darSegundoProducto().darValorUnitario();
        double valorProducto3 = darTercerProducto().darValorUnitario()
                * darTercerProducto().darIVA();
        valorProducto3 = valorProducto3 + darTercerProducto().darValorUnitario();
        double valorProducto4 = darCuartoProducto().darValorUnitario()
                * darCuartoProducto().darIVA();
        valorProducto4 = valorProducto4 + darCuartoProducto().darValorUnitario();

        if(valorProducto1<valorProducto2 &&
                valorProducto1<valorProducto3 &&
                valorProducto1<valorProducto4){
            nombreProducto = darPrimerProducto().darNombre();
        }

        if(valorProducto2<valorProducto1 &&
                valorProducto2<valorProducto3 &&
                valorProducto2<valorProducto4){
            nombreProducto = darSegundoProducto().darNombre();
        }

        if(valorProducto3<valorProducto1 &&
                valorProducto3<valorProducto2 &&
                valorProducto3<valorProducto4){
            nombreProducto = darTercerProducto().darNombre();
        }

        if(valorProducto4<valorProducto1 &&
                valorProducto4<valorProducto2 &&
                valorProducto4<valorProducto3){
            nombreProducto = darCuartoProducto().darNombre();
        }

        return nombreProducto;
    }
}