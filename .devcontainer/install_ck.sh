#!/bin/bash
set -e

CK_VERSION="8583e1cfcceb10303bf0f0bb61d0d84ff6670e84"
CK_MVN_PLUGIN_VERSION="f107e7734adf57a9d9fe82fedf9fefa3eadf2d64"

pushd /tmp

# download and install CK
git clone https://github.com/mauricioaniche/ck
pushd ck
git checkout ${CK_VERSION}
mvn clean install
popd
rm -rf ck

# download and install maven plugin
git clone https://github.com/jazzmuesli/ck-mvn-plugin
pushd ck-mvn-plugin
git checkout ${CK_MVN_PLUGIN_VERSION}
mvn clean install
popd
rm -rf ck-mvn-plugin
