#include <iostream>
#include "SDL.h"
#include "matrix.h"
#include <cmath>
#include <string>
#define PI 3.14159265
//#include "VM.h"
//class Vector;
class Engine
{
private:
    bool flagToExit = false;
    int height;
    int width; // размер окна в пикселях
    std::string value;
    SDL_Window* window = NULL;
    SDL_Renderer* renderer = NULL;
 
    int Init()
    {
        if (SDL_Init(SDL_INIT_EVERYTHING) == -1)
        {
            std::cout << SDL_GetError() << "\n";
            return -2;
        }

        window = SDL_CreateWindow("Laba3", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, height, width,
            SDL_WINDOW_VULKAN | SDL_WINDOW_BORDERLESS);
        if (window == NULL)
        {
            std::cout << SDL_GetError() << "\n";
            return -3;
        }
        renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
        return 10;
    };

    void Render()
    {
        SDL_SetRenderDrawColor(renderer, 0, 0, 0, SDL_ALPHA_OPAQUE);
        SDL_RenderClear(renderer);
        SDL_SetRenderDrawColor(renderer, 255, 255, 255, SDL_ALPHA_OPAQUE);
        char n; cout << "Enter 'A' to spin the figure, then enter an integer angle: 0 < angle < 90\n" 
            << "Enter 'F' to see the original figure\n"
            << "Enter 'M' to move the figure, then enter 'x' or 'y'\n"
            << "Enter 'S' to change the size of the figure, then enter a number\n"; cin >> n;
        Vector v1(100, 550);
        Vector v2(40, 500);
        Vector v3(110, 500);
        Vector v4(50, 550);
        Vector v5(75, 475);
        Matrix mb = mxangl(1, 0, 0, 1); //1-matrix

        switch (n) {
        case 'F': {
            Matrix m1 = mb * v1; //converting vectors to matrices 
            Matrix m2 = mb * v2;
            Matrix m3 = mb * v3;
            Matrix m4 = mb * v4;
            Matrix m5 = mb * v5;
            SDL_RenderDrawLine(renderer, m5(0, 0), m5(0, 1), m1(0, 0), m1(0, 1));
            SDL_RenderDrawLine(renderer, m1(0, 0), m1(0, 1), m2(0, 0), m2(0, 1));
            SDL_RenderDrawLine(renderer, m2(0, 0), m2(0, 1), m3(0, 0), m3(0, 1));
            SDL_RenderDrawLine(renderer, m3(0, 0), m3(0, 1), m4(0, 0), m4(0, 1));
            SDL_RenderDrawLine(renderer, m4(0, 0), m4(0, 1), m5(0, 0), m5(0, 1));
            break;}
        case 'A': {
            int angle; cin >> angle;
            Matrix ma = mxangl(cos(PI * angle / 180), sin(PI * angle / 180), 
                                -sin(PI * angle / 180), cos(PI * angle / 180));
            Matrix mc = ma.transpose();
            Matrix m1 = mc * v1;
            Matrix m2 = mc * v2;
            Matrix m3 = mc * v3;
            Matrix m4 = mc * v4;
            Matrix m5 = mc * v5;
            SDL_RenderDrawLine(renderer, m5(0, 0), m5(0, 1), m1(0, 0), m1(0, 1));
            SDL_RenderDrawLine(renderer, m1(0, 0), m1(0, 1), m2(0, 0), m2(0, 1));
            SDL_RenderDrawLine(renderer, m2(0, 0), m2(0, 1), m3(0, 0), m3(0, 1));
            SDL_RenderDrawLine(renderer, m3(0, 0), m3(0, 1), m4(0, 0), m4(0, 1));
            SDL_RenderDrawLine(renderer, m4(0, 0), m4(0, 1), m5(0, 0), m5(0, 1));
            break;}
        case 'M': {
            
            char k; cin >> k; 
            Matrix m1 = mb * v1;
            Matrix m2 = mb * v2;
            Matrix m3 = mb * v3;
            Matrix m4 = mb * v4;
            Matrix m5 = mb * v5;
            switch (k) {
            case 'x': {
                m1(0, 0) += 100;
                m2(0, 0) += 100;
                m3(0, 0) += 100;
                m4(0, 0) += 100;
                m5(0, 0) += 100;
                SDL_RenderDrawLine(renderer, m5(0, 0), m5(0, 1), m1(0, 0), m1(0, 1));
                SDL_RenderDrawLine(renderer, m1(0, 0), m1(0, 1), m2(0, 0), m2(0, 1));
                SDL_RenderDrawLine(renderer, m2(0, 0), m2(0, 1), m3(0, 0), m3(0, 1));
                SDL_RenderDrawLine(renderer, m3(0, 0), m3(0, 1), m4(0, 0), m4(0, 1));
                SDL_RenderDrawLine(renderer, m4(0, 0), m4(0, 1), m5(0, 0), m5(0, 1));
                break;}
            case 'y': {
                m1(0, 1) += 100;
                m2(0, 1) += 100;
                m3(0, 1) += 100;
                m4(0, 1) += 100;
                m5(0, 1) += 100;
                SDL_RenderDrawLine(renderer, m5(0, 0), m5(0, 1), m1(0, 0), m1(0, 1));
                SDL_RenderDrawLine(renderer, m1(0, 0), m1(0, 1), m2(0, 0), m2(0, 1));
                SDL_RenderDrawLine(renderer, m2(0, 0), m2(0, 1), m3(0, 0), m3(0, 1));
                SDL_RenderDrawLine(renderer, m3(0, 0), m3(0, 1), m4(0, 0), m4(0, 1));
                SDL_RenderDrawLine(renderer, m4(0, 0), m4(0, 1), m5(0, 0), m5(0, 1));
                break;}
            }
            break;}
        case 'S': {
            float k; cin >> k;
            Matrix mc = mxangl(k, 0, 0, k); // 1-matrix * coeff
            Matrix m1 = mc * v1;
            Matrix m2 = mc * v2;
            Matrix m3 = mc * v3;
            Matrix m4 = mc * v4;
            Matrix m5 = mc * v5;
            SDL_RenderDrawLine(renderer, m5(0, 0), m5(0, 1), m1(0, 0), m1(0, 1));
            SDL_RenderDrawLine(renderer, m1(0, 0), m1(0, 1), m2(0, 0), m2(0, 1));
            SDL_RenderDrawLine(renderer, m2(0, 0), m2(0, 1), m3(0, 0), m3(0, 1));
            SDL_RenderDrawLine(renderer, m3(0, 0), m3(0, 1), m4(0, 0), m4(0, 1));
            SDL_RenderDrawLine(renderer, m4(0, 0), m4(0, 1), m5(0, 0), m5(0, 1));
            break;
        }
        default:
            cout << "Incorrect input. Try again\n";
            break;
        }
        

        SDL_RenderPresent(renderer);
    };

    void PollsEvent()
    {
        SDL_Event event;
        SDL_PollEvent(&event);
        switch (event.type)
        {
        case SDL_QUIT:
            flagToExit = true;
            break;

        case SDL_KEYDOWN:
            switch (event.key.keysym.sym)
            {
            case SDLK_ESCAPE:
                flagToExit = true;
                break;
            case SDLK_SPACE:
                std::cout << "i'm here"
                    << "\n";
                break;

            default:
                break;

            }
            break;
        default:
            break;
        }
    };

    void Update() {
        /*
         * В данной функции реализуется логика вызова методов
         * для операций над матрицами и векторами.
         *
         *
         * */
    };

public:
    friend class Vector;
    Engine(int height, int width)
    {
        this->height = height;
        this->width = width;
    };

    ~Engine() {};

    void Run()
    {
        Init();
        while (!flagToExit)
        {
            PollsEvent();
            Update();
            Render();
        }
        SDL_DestroyRenderer(renderer);
        std::cout << "renderer memory finalized"
            << "\n";
        SDL_DestroyWindow(window);
        std::cout << "window memory finalized"
            << "\n";
        SDL_Quit();
        std::cout << "SDL memory finalized"
            << "\n";
    }
};

int main(int argc, char* argv[])
{

    Engine visualMath = Engine(1000, 1000);
    visualMath.Run();
    return 0;
}