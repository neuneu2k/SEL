/*
 * Copyright 2014 Josselin Pujo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
"use strict";
var JavaTypes = {
  "BOOL": ["bool", "true"],
  "INT": ["int", "0"],
  "LONG": ["long", "0"],
  "FLOAT": ["float", "0.0"],
  "DOUBLE": ["double", "0.0"],
  "BYTES": ["byte[]", "null"],
  "STRING": ["String", "null"]
}

var JavaCommon = {
  "common.DateTime": "DateTime"
}
var template = IO.readFile("SingleClassJava.template")
var tmpl = Handlebars.compile(template)
Handlebars.registerHelper("BeanNC", function (name) {
  return name.charAt(0).toUpperCase() + name.slice(1)
})

var decl = function (type) {
  if (type.refType === "SCALAR") {
    return JavaTypes[type.scalar][0]
  } else if (type.refType === "REF") {
    if (JavaCommon[type.typeRef]) {
      return JavaCommon[type.typeRef]
    } else {
      return type.typeRef
    }
  } else if (type.refType === "LIST") {
    return new Handlebars.SafeString("List<" + decl(type.collectionRefType) + ">")
  } else if (type.refType === "MAP") {
    return new Handlebars.SafeString("Map<String," + decl(type.collectionRefType) + ">")
  }
}

var init = function (type) {
  if (type.refType === "SCALAR") {
    return JavaTypes[type.scalar][1]
  } else if (type.refType === "REF") {
    return "null"
  } else if (type.refType === "LIST") {
    return new Handlebars.SafeString("new ArrayList<" + decl(type.collectionRefType) + ">()")
  } else if (type.refType === "MAP") {
    return new Handlebars.SafeString("new HashMap<String," + decl(type.collectionRefType) + ">()")
  }
}

Handlebars.registerHelper('decl', function (type) {
  return decl(type)
})
Handlebars.registerHelper('init', function (type) {
  return init(type)
})

var nsToPath = function (ns) {
  return ns.replace(/\./g, '/')
}

_.each(namespaces, function (namespace) {
  IO.writeFile(nsToPath(namespace['name']) + "/Entities.java", tmpl({namespace: namespace}))
})
