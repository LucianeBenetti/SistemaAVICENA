/**
  * Função para aplicar máscara em campos de texto
  * Copyright (c) 2008, Dirceu Bimonti Ivo - http://www.bimonti.net
  * All rights reserved.
  * @constructor
  */
/* Version 0.27 */
/**
 * 
 * @param {type} w
 * @param {type} e
 * @param {type} m
 * @param {type} r
 * @param {type} a
 * @returns {Boolean}
 *
 
 maskIt
 
 Sintaxe: maskIt (w,e,m[,r[,a]]);
 Retorno: nenhum.
 Descrição: Aplica uma máscara no campo do tipo texto.
 Explicação adicional: Função para aplicação de máscara em campos input do tipo texto. Funções com formato pré definidos funcionam melhor (CPF) que formatos variáveis (moeda).
 
 Os argumentos da função são:
 
 w: Referência ao elemento. Normalmente é this.
 e: Evento usado para cancelar o Backspace.
 m: Máscara a ser aplicada.
 r: Aplicar a mascara da direita para a esquerda. Opcional [true|false] - Dafault : false.
 a: Objeto com informações para aplicar após a máscara. Use você precisar aplicar alguma informação sempre no começo ou no fim do valor independente da máscara, como exemplo "R$" em campos do tipo monetário. Sintaxe: {[pre:'value'[,pos:'value']]}.
 **/
/**
 
 * Função Principal 
 * @param w - O elemento que será aplicado (normalmente this). 
 * @param e - O evento para capturar a tecla e cancelar o backspace. 
 * @param m - A máscara a ser aplicada. 
 * @param r - Se a máscara deve ser aplicada da direita para a esquerda. Veja Exemplos. 
 * @param a - 
 * @returns null
 
 */

function maskIt(w, e, m, r, a) {

// Cancela se o evento for Backspace
    if (!e)
        var e = window.event

    if (e.keyCode)
        code = e.keyCode;

    else if (e.which)
        code = e.which;

// Variáveis da função

    var txt = (!r) ? w.value.replace(/[^\d]+/gi, '') : w.value.replace(/[^\d]+/gi, '').reverse();

    var mask = (!r) ? m : m.reverse();

    var pre = (a) ? a.pre : "";

    var pos = (a) ? a.pos : "";

    var ret = "";

    if (code == 9 || code == 8 || txt.length == mask.replace(/[^#]+/g, '').length)
        return false;

// Loop na máscara para aplicar os caracteres

    for (var x = 0, y = 0, z = mask.length; x < z && y < txt.length; ) {

        if (mask.charAt(x) != '#') {

            ret += mask.charAt(x);
            x++;

        } else {

            ret += txt.charAt(y);
            y++;
            x++;

        }

    }

// Retorno da função

    ret = (!r) ? ret : ret.reverse()

    w.value = pre + ret + pos;

}

// Novo método para o objeto 'String'

String.prototype.reverse = function () {

    return this.split('').reverse().join('');

};