{
  description = "Mill build for xrpl4j";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};

        fhs = pkgs.buildFHSEnv {
          name = "xrpl4j-dev";
          targetPkgs = pkgs: with pkgs; [
            jdk17
            maven
            git
          ];
          runScript = "bash";
          profile = ''
            export PATH=$PWD:$PATH
          '';
        };

      in
      {
        devShells.default = fhs;
      }
    );
}
