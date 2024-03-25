#!/bin/bash

pushd $HOME

wget https://github.com/pmd/pmd/releases/download/pmd_releases%2F7.0.0-rc4/pmd-dist-7.0.0-rc4-bin.zip

unzip pmd-dist-7.0.0-rc4-bin.zip

echo 'export PATH=/home/vscode/pmd-bin-7.0.0-rc4/bin/:$PATH' >> ~/.bashrc

rm pmd-dist-7.0.0-rc4-bin.zip
