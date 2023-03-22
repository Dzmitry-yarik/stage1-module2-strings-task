package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String accessModifier = " ";
        String type;
        String name;
        MethodSignature.Argument argument;
        List<MethodSignature.Argument> arguments = new ArrayList<>(List.of());
        MethodSignature method = new MethodSignature(accessModifier, arguments);

        String q = "";
        String w = "";
        int i = 0;
        StringTokenizer st = new StringTokenizer(signalString, "(");
        while(st.hasMoreTokens()) {
            if (i == 0){
                 q = st.nextToken();
            }
            if (i == 1) {
                 w = st.nextToken();
            }
            i++;
        }

        String[] string2 = q.split(" ");

        if(string2.length == 3) {
            method.setAccessModifier(string2[0]);
            method.setReturnType(string2[1]);
            method.setMethodName(string2[2]);
        }
        if(string2.length == 2) {
            method.setReturnType(string2[0]);
            method.setMethodName(string2[1]);
        }

        String e = w.replace(')', ' ');
        String[] arg = e.split(",");

        for (String s : arg) {
            String ss = s.trim();
            String[] argI = ss.split(" ");
            type = argI[0];
            name = argI[1];
            argument = new MethodSignature.Argument(type, name);
            arguments.add(argument);
        }

        return method;
    }
}
