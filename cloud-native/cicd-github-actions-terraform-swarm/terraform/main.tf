terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {
  host = "unix:///var/run/docker.sock"
}

# In a real environment, this would provision EC2 instances, setup Swarm, etc.
# For workshop purposes, we just demonstrate creating a Docker network.
resource "docker_network" "app_network" {
  name   = "cicd_app_network"
  driver = "overlay"
}
