#!/bin/bash
set -e

HERE_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

"${HERE_DIR}/install_infer.sh"
"${HERE_DIR}/install_pmd.sh"
"${HERE_DIR}/install_ck.sh"
"${HERE_DIR}/mvn_compile.sh"
