package com.cpxall.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cpxall
 */
public class Utilidades {

    public static String fechaDinamica() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.SECOND) + "-" + cal.get(Calendar.MINUTE) + "-" + cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
    }

    public static String fechaDinamicaDiaMesAno() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
    }

    public static LinkedList<String> paginate(int numeropaginar, int paginacion, String Url) {
        LinkedList<String> lista = new LinkedList<>();
        if (numeropaginar % paginacion == 0) {
            for (int x = 0; x < (numeropaginar / paginacion); x++) {

                lista.add(Url);
            }

        } else {
            for (int x = 0; x <= (numeropaginar / paginacion); x++) {

                lista.add(Url);
            }
        }
        return lista;
    }

    public static void main(String arg[]) {
        String fecha = "02/16/2011";
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);

        Date StringToDate = Utilidades.StringToDateMesDiaAno(fecha, "/");
        cal.setTime(StringToDate);
        //System.out.print(cal.get(Calendar.DAY_OF_MONTH));

        //System.out.print( Utilidades.fechaMayor(cal));
        System.out.print(cal.get(Calendar.DAY_OF_MONTH));
        //System.out.print( Utilidades.isEmail("gesm..elloc@hotma.com"));

    }

    public static boolean prueba(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("([0-9a-zA-Z]([_.])*@)$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        } else {
            return false;
        }
    }

    /*valida la fecha ingresada por el usuario para ver si es valida*/
    public static boolean fechaValida(String fecha) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            sdf.setLenient(false);
            sdf.parse(fecha);
        } catch (ParseException ex) {

            return false;
        }
        return true;
    }

    /*Convierte una cadena a date con el siguiente Formato(yyyy-MM-dd)*/
    public static Date StringToDate(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date fechaFormato = null;
        try {

            sdf.setLenient(false);
            fechaFormato = sdf.parse(fecha);
        } catch (ParseException ex) {

        }
        return fechaFormato;
    }

    public static Date StringToDateMesDiaAno(String fecha, String clave) {
        SimpleDateFormat sdf = null;
        Date fechaFormato = null;

        String union = null;
        try {
            if (clave.equals("/")) {
                sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                union = fecha.substring(6, 10) + "/" + fecha.substring(0, 2) + "/" + fecha.substring(3, 5);
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                union = fecha.substring(6, 10) + "-" + fecha.substring(0, 2) + "-" + fecha.substring(3, 5);

            }
            sdf.setLenient(false);
            fechaFormato = sdf.parse(union);
        } catch (ParseException ex) {

        }
        return fechaFormato;
    }

    /*Convierte un Date a String con el siguiente Formato(yyyy-MM-dd)*/
    public static String DateToString(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormato = null;

        sdf.setLenient(false);
        fechaFormato = sdf.format(fecha);

        return fechaFormato;
    }

    /*Agrega dias a una fecha*/
    public static Date agregarDias(Date fecha, int dia) {

        Calendar cal = new GregorianCalendar();
        cal.setLenient(false);
        cal.setTime(fecha);

//cal.set(cal.get(Calendar.YEAR)+ano,cal.get( Calendar.MONTH)+mes,cal.get( Calendar.DAY_OF_MONTH)+dia);
        cal.add(Calendar.DAY_OF_MONTH, dia);

        return cal.getTime();

    }

    /*Quita dias a una fecha*/
    public static Date quitarDias(Date fecha, int dia) {

        Calendar cal = new GregorianCalendar();
        cal.setLenient(false);
        cal.setTime(fecha);

        cal.add(Calendar.DAY_OF_MONTH, -dia);

        return cal.getTime();

    }

    /*Devuelve verdadero si la fecha ingresada por el usuario es mayor que la del sistema*/
    public static boolean fechaMayor(Calendar fechaUsuario) {
        Calendar fechaSistema = Calendar.getInstance();
        if (fechaSistema.after(fechaUsuario)) {
            return false;
        }
        return true;
    }

    /*Devuelve los metadatos de la base de datos con sus propiedades*/

 /*convierte un date a Calendar*/
    public static Calendar DateFecha(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(fecha);
        return calendar;
    }

    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])"
                + "*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)"
                + "+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        } else {
            return false;
        }
    }

    public static boolean copiarArchivos(FileInputStream archivo, String rutaGuardar) {

        try {
            InputStream in = archivo;
            OutputStream out = new FileOutputStream(rutaGuardar);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean validarArchivo(String cadena) {
        String input = cadena;
        Pattern p = Pattern.compile("[^\\<>\\*\\?\"/]$");
        Matcher m = p.matcher(input);
        Pattern patron2 = Pattern.compile("[0-9A-za-z-_,]\\.{1}\\.*+[a-zA-z]{2}");
        //
        if (m.find()) {
            m = patron2.matcher(input);
            if (m.find()) {
                return true;
            }
        }
        return false;
    }
//Abre un archivo cualquiera llamando al predeterminado por el sistema

    public static boolean abrirArchivos(File archivo) throws IOException, Exception {
        if (Utilidades.validarArchivo(archivo.getName())) {
            Pattern patron2 = Pattern.compile("[0-9A-za-z-_,]\\.{1}\\.*jrprint");
            Matcher m = patron2.matcher(archivo.getName());
            if (m.find()) {
                Reportes repor = new Reportes();
                repor.mostrarReporte(archivo.getAbsolutePath());
                return true;
            }
            if (Desktop.isDesktopSupported() == true) {
                //obtengo la instancia de la clase Desktop del entorno actual
                Desktop desktop = Desktop.getDesktop();
                if (archivo.canExecute()) {
                    //ejecuto el archivo o URI
                    desktop.open(archivo);
                } else {
                    //sino, lanzo una execpcion con las dos posibles causas de error
                    throw new Exception("No se encontro el archivo " + archivo.getAbsolutePath() + " o no cuenta con permisos para ejecutarlo");
                }
            } else {
                //la clase no es soportada
                throw new Exception("No se puede ejecutar el comando de apertura en este sistema operativo");
            }
            return true;
        }
        return false;
    }
}
