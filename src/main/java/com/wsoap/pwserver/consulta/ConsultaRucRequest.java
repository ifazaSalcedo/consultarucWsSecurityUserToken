//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.03.05 a las 10:26:16 AM PYST 
//


package com.wsoap.pwserver.consulta;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rucParamentro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rucParamentro"
})
@XmlRootElement(name = "consultaRucRequest")
public class ConsultaRucRequest {

    @XmlElement(required = true)
    protected String rucParamentro;

    /**
     * Obtiene el valor de la propiedad rucParamentro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRucParamentro() {
        return rucParamentro;
    }

    /**
     * Define el valor de la propiedad rucParamentro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRucParamentro(String value) {
        this.rucParamentro = value;
    }

}