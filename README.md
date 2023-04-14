Se desea calcular el dígito verificador de un rut, para ello se tienen los siguientes pasos:

Se ingresa un rut, por ejemplo 12.345.678-5

Se toman los números del rut sin el dígito verificador, en este caso, 12345678

Invertir el orden de la cadena, en este caso, 87654321

Multiplicar cada dígito por la siguiente cadena 2, 3, 4, 5, 6, 7 y si se acaba la serie, volvemos a empezar 2, 3, 4... En este caso, 8 x 2, 7 x 3, 6 x 4, 5 x 5, 4 x 6, 3 x 7, 2 x 2, 1 x 3.

Sumar cada resultado de las multiplicaciones y dividir por 11. En este caso, 138 / 11 = 12.54

Se toma el resultado sin los decimales y sin aproximar, luego se multiplica por 11. En este caso 12 x 11= 132

A la suma de las multiplicaciones obtenidas en el paso 4, se le resta la multiplicación del paso 6 y se deja en valor absoluto (signo positivo). En este caso 138 - 132 = 6

Para finalizar, a 11 le restamos el resultado de la resta en el paso 7, obteniendo el dígito verificador. Si da 10=k, 11=0. En este caso 11 - 6 = 5

Implemente una solución en Java que permita calcular el dígito verificador del rut, el cual debe ser ingresado por teclado y validado a partir de pruebas unitarias y gestión de excepciones.

Adicionalmente, compare su código con el resultado que saldría en ChatGPT e indique cada diferencia que pueda haber en el README.md de su proyecto. Su código estará en una clase llamada ValidadorRut y el código de ChatGPT en una clase llamada ValidadorRutGPT.

**Comparacion con ChatGPT**

Comparando el código con el de ChatGPT, creo que los dos tienen una forma muy similar de realizar las tareas. La gran diferencia observable es que mi código está escrito de forma funcional, dividiendo todas las tareas en métodos. En cambio ChatGPT solo tiene 2, el main() y el calculateVerifierDigit(), lo que no es muy buena práctica.

También cabe destacar que ChatGPT incluyó menos pasos, pero aún así llego a los mismos resultados.