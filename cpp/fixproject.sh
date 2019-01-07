#!/bin/bash
#https://github.com/exercism/cpp/issues/116
set -ue
project="${1:?ERROR: Name of directory with exercism CPP project code is required.}"

project_name="${project//-/_}"

cd "$project"

# Create empty .cpp and .h files
touch "$project_name."{cpp,h}

# Turn off static (.a) linking for boost libraries, because only dynamic (.so) libraries are available
sed -i 's/set(Boost_USE_STATIC_LIBS ON)/set(Boost_USE_STATIC_LIBS OFF)/' CMakeLists.txt

# Add def BOOST_TEST_DYN_LINK to *_test.cpp, to generate main()
fgrep -q '#define BOOST_TEST_DYN_LINK' "${project_name}_test.cpp" || {
  sed -i '/#define BOOST_TEST_MAIN/ a#define BOOST_TEST_DYN_LINK' "${project_name}_test.cpp"
}

# Enable all test cases and generate Makefile
cmake -DEXERCISM_RUN_ALL_TESTS=yes .

# Build project
make
